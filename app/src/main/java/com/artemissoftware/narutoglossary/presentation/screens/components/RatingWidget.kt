package com.artemissoftware.narutoglossary.presentation.screens.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.artemissoftware.narutoglossary.R

@Composable
fun RatingWidget(
    modifier: Modifier,
    rating: Double,
    scaleFactor: Float = 3f,
//    spaceBetween: Dp = EXTRA_SMALL_PADDING
) {
//    val result = calculateStars(rating = rating)

    val starPathString = stringResource(id = R.string.star_path)
    val starPath = remember {
        PathParser().parsePathString(pathData = starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }

//    Row(
//        modifier = modifier,
//        horizontalArrangement = Arrangement.spacedBy(spaceBetween)
//    ) {
//        result["filledStars"]?.let {
//            repeat(it) {
//                FilledStar(
//                    starPath = starPath,
//                    starPathBounds = starPathBounds,
//                    scaleFactor = scaleFactor
//                )
//            }
//        }
//        result["halfFilledStars"]?.let {
//            repeat(it) {
//                HalfFilledStar(
//                    starPath = starPath,
//                    starPathBounds = starPathBounds,
//                    scaleFactor = scaleFactor
//                )
//            }
//        }
//        result["emptyStars"]?.let {
//            repeat(it) {
//                EmptyStar(
//                    starPath = starPath,
//                    starPathBounds = starPathBounds,
//                    scaleFactor = scaleFactor
//                )
//            }
//        }
//    }

}