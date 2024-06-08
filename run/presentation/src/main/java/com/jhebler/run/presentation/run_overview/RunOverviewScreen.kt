package com.jhebler.run.presentation.run_overview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jhebler.core.presentation.designsystem.RuniqueAppTheme
import org.koin.androidx.compose.koinViewModel

@Composable

fun RunOverviewScreenRoot(
    viewModel: RunOverviewViewModel = koinViewModel()
) {
    RunOverviewScreen(
        onAction = viewModel::onAction
    )
}

@Composable
private fun RunOverviewScreen(
    onAction: (RunOverviewAction) -> Unit
) {
    
}

@Preview

@Composable
private fun RunOverviewScreenPreview() {
     RuniqueAppTheme {
        RunOverviewScreen(
            onAction = {}
        )
    }
}