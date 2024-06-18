package data.remote

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.network.parseGetRequest
import com.fleeksoft.ksoup.nodes.Document
import domain.model.Chapter
import domain.model.Course
import domain.repository.CourseRepository


class CourseRepositoryImp : CourseRepository {
    companion object {
        const val BASE_URL = "https://beta-cursos.vercel.app/"
        const val SCRIP_DATA = "${BASE_URL}Curso/index.js"
    }

    override suspend fun getCourses(): List<Course> {
        val doc: Document = Ksoup.parseGetRequest(url = BASE_URL)

        val courses = doc.selectFirst("div.container")?.selectFirst("div.row")?.children()?.map {
            val image = it.select("img").first()?.attr("src")
            val title = it.select("h5.card-title").text()
            /*

                onclick="TipoCurso('AvanzadodeProgramaciónGo2021Platzi', 19, 3)"
                onclick="TipoCurso('Angular')"

             */

            val onClickData = it.select("a").first()?.attr("onclick")
            val regex =
                """TipoCurso\('([^']+)',\s*(\d+),\s*(\d+)\)|TipoCurso\('([^']+)'\)""".toRegex()
            val match = regex.find(onClickData!!)!!

            val key = match.groupValues[1].ifEmpty { match.groupValues[4] }
            val number1 = match.groupValues[2].toIntOrNull() ?: -1
            val number2 = match.groupValues[3].toIntOrNull() ?: -1

            Course(title = title, image = image!!, key = key, enabled = number2, total = number1)
        }.orEmpty()

        return courses
    }

    override suspend fun getChapters(keyCourse: String, enabled: Int, total: Int): List<Chapter> {
        println("getChapters #$keyCourse $enabled $total")
        val chapters = mutableListOf<Chapter>()

        if (enabled == -1 || total == -1) {
            // Its Angular Course
            val doc: Document = Ksoup.parseGetRequest(url = SCRIP_DATA)

            val regex = """let\s+urls\s*=\s*\[([^\]]*)\]""".toRegex()

            val matchResult = regex.find(doc.toString())

            val urlsString = matchResult?.groups?.get(1)?.value ?: ""

            val urls = urlsString.split(",\\s*".toRegex())
                .map {
                  it.replace("\"".toRegex(),"").trim()
                }.filter { it != "vacio" }

            urls.forEachIndexed { index, url ->
                chapters.add(Chapter(index = index+1, link = url))
            }

        } else {
            // Get Base Url Links
            // Enable 3
            // Total 4
            //         localStorage.setItem("capitulo", `https://vlink.lol/vfm/play/${localStorage.getItem("curso")}/${cap}.mp4`);
            (1..total).forEach {
                val soon = it > enabled
                val videoUrl = "https://vlink.lol/vfm/play/${keyCourse}/${it}.mp4"
                chapters.add(Chapter(index = it, link = if (soon) "" else videoUrl, soon = soon))
            }
        }

        return chapters
    }
}

suspend fun main() {
    /*
    val courses = CourseRepositoryImp().getCourses().forEach {
        println(it)
        CourseRepositoryImp().getChapters(it.key, total = it.total, enabled = it.enabled).let(::println)
    }*/
    val key = "CursoAPIRESTconExpress.js"
    CourseRepositoryImp().getChapters(key, total = 8, enabled = 17).let(::println)

}