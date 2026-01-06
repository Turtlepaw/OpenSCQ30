package com.oppzippy.openscq30.ui.utils

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oppzippy.openscq30.ui.theme.OpenSCQ30Theme

@Composable
fun LabeledSwitch(
    label: String,
    isChecked: Boolean,
    onCheckedChange: (value: Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    Labeled(
        modifier = modifier
            .clip(
                MaterialTheme.shapes.medium
            )
            .toggleable(
                value = isChecked,
                onValueChange = onCheckedChange,
                role = Role.Switch,
                interactionSource = interactionSource
            )
            .padding(10.dp),
        label = label,
    ) {
        Switch(
            checked = isChecked,
            onCheckedChange = null,
            interactionSource = interactionSource
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewLabeledSwitch() {
    OpenSCQ30Theme {
        LabeledSwitch(label = "Switch", isChecked = true, onCheckedChange = {})
    }
}
