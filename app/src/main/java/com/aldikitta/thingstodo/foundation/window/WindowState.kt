package com.aldikitta.thingstodo.foundation.window

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.*

/**
 * Data class that contains foldable and large screen information extracted from the Jetpack
 * Window Manager library
 *
 * @param hasFold: true if window contains a FoldingFeature,
 * @param foldIsHorizontal: true if window contains a FoldingFeature with a horizontal orientation
 * @param foldBoundsDp: DpRect object that describes the bound of the FoldingFeature in Dp
 * @param foldState: state of the fold, based on state property of FoldingFeature
 * @param foldIsSeparating: based on isSeparating property of FoldingFeature
 * @param foldIsOccluding: true if FoldingFeature occlusion type is full
 * @param windowWidthDp: Dp value of the window width
 * @param windowHeightDp: Dp value of the window height
 */
data class WindowState(
    val hasFold: Boolean = false,
    val foldIsHorizontal: Boolean = false,
    val foldBoundsDp: DpRect = DpRect(0.dp, 0.dp, 0.dp, 0.dp),
    val foldState: FoldState = FoldState.FLAT,
    val foldIsSeparating: Boolean = false,
    val foldIsOccluding: Boolean = false,
    val windowWidthDp: Dp = 0.dp,
    val windowHeightDp: Dp = 0.dp,
) {
    /**
     * Dp value of the width of the hinge or the folding line if it is separating, otherwise 0
     */
    val foldSizeDp: Dp =
        if (foldIsSeparating) {
            if (foldIsHorizontal) foldBoundsDp.height else foldBoundsDp.width
        } else {
            0.dp
        }

    /**
     * Current window mode (single portrait, single landscape, dual portrait, or dual landscape)
     */
    val windowMode: WindowMode
        @Composable get() {
            val isPortrait = windowIsPortrait()
            return calculateWindowMode(isPortrait)
        }

    /**
     * Proportion of the window that pane 1 should occupy on a large screen. Used when calculating pane size for
     * the `pane1SizeDp` and `pane2SizeDp` properties.
     *
     * Must be between 0 and 1 - default value is 0.5 to create equal panes
     */
    var largeScreenPanelWeight: Float = 0.5f
        set(value) {
            checkWeght(value)
            field = value
        }

    /**
     * Helper method to check the validity of a pane weight
     *
     * If the given weight is <=0 or >=1, then an exception is thrown
     */
    private fun checkWeight(weight: Float) {
        // Check that 0 < weight < 1
        if (weight <= 0f || weight >= 1f)
            throw IllegalArgumentException("Pane 1 weight must be between 0 and 1")
    }
}