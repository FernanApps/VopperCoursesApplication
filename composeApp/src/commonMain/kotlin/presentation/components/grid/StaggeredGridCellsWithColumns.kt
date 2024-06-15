package presentation.components.grid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class StaggeredGridCellsWithColumns {


    class Adaptive(private val minSize: Dp, val onCountColumns: (Int) -> Unit) :
        StaggeredGridCells {
        init {
            require(minSize > 0.dp) { "invalid minSize" }
        }

        override fun Density.calculateCrossAxisCellSizes(
            availableSize: Int,
            spacing: Int
        ): IntArray {
            val count = maxOf((availableSize + spacing) / (minSize.roundToPx() + spacing), 1)
            onCountColumns(count)
            return calculateCellsCrossAxisSizeImpl(availableSize, count, spacing)
        }

        override fun hashCode(): Int {
            return minSize.hashCode()
        }

        override fun equals(other: Any?): Boolean {
            return other is StaggeredGridCells.Adaptive /*&& minSize == other.minSize*/
        }

        fun calculateCellsCrossAxisSizeImpl(
            gridSize: Int,
            slotCount: Int,
            spacing: Int
        ): IntArray {
            val gridSizeWithoutSpacing = gridSize - spacing * (slotCount - 1)
            val slotSize = gridSizeWithoutSpacing / slotCount
            val remainingPixels = gridSizeWithoutSpacing % slotCount
            return IntArray(slotCount) {
                slotSize + if (it < remainingPixels) 1 else 0
            }
        }
    }

}

