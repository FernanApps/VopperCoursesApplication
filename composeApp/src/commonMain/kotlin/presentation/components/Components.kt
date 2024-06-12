package presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun IconButtonBack(onBack: () -> Unit){
    IconButton(onClick = {
        onBack()
    }) {
        Icon(imageVector = Icons.Filled.ArrowBackIosNew, "ArrowBackIosNew")
    }
}