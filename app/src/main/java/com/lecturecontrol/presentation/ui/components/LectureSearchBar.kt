package com.lecturecontrol.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lecturecontrol.presentation.ui.theme.MainPurple

@Composable
fun LectureSearchBar(onSearch: (String) -> Unit) {
    val searchText: MutableState<String> = remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 25.dp),
        value = searchText.value,
        onValueChange = {
            searchText.value = it
            onSearch(it)
        },
        textStyle = TextStyle(color = Color.Black),
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search",
                tint = MainPurple
            )
        },
        placeholder = {
            Text(
                text = "Procurar",
                style = TextStyle(color = Color.Gray)
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            cursorColor = Color.Black,
            leadingIconColor = Color.Gray,
            placeholderColor = Color.Gray,
            focusedBorderColor = MainPurple,
            unfocusedBorderColor = Color.Gray,
            focusedLabelColor = MainPurple,
            unfocusedLabelColor = Color.Gray
        ),
        shape = RoundedCornerShape(20.dp),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
    )
}

@Preview
@Composable
fun LectureSearchBarPreview() {
    LectureSearchBar(onSearch = {})
}
