package com.lecturecontrol.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.lecturecontrol.R
//
//val openSans = FontFamily(
//    Font(R.font.open_sans_light_tff, FontWeight.Light),
//    Font(R.font.open_sans_tff, FontWeight.Normal),
//    Font(R.font.open_sans_semibold_tff, FontWeight.SemiBold),
//    Font(R.font.open_sans_bold_tff, FontWeight.Bold)
//)

/** Converte DP em SP, assim é possível que um texto não mude de tamanho,
 * mesmo que nas configurações do celular a fonte esteja configurada com ou sem zoom */
@Composable
fun dpToSp(dp: Dp) = with(LocalDensity.current) { dp.toSp() }

val Typography = Typography(
//    h1 = TextStyle(
//        fontFamily = openSans,
//        fontWeight = FontWeight.Bold,
//        fontSize = 20.sp
//    ),
//    h2 = TextStyle(
//        fontFamily = openSans,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp
//    ),
//    h3 = TextStyle(
//        fontFamily = openSans,
//        fontSize = 14.sp,
//        fontWeight = FontWeight.Normal
//    ),
//    h4 = TextStyle(
//        fontFamily = openSans,
//        fontSize = 13.sp,
//        fontWeight = FontWeight.Normal
//    ),
//    h5 = TextStyle(
//        fontFamily = openSans,
//        fontSize = 12.sp,
//        fontWeight = FontWeight.Normal
//    ),
//    h6 = TextStyle(
//        fontFamily = openSans,
//        fontSize = 10.sp,
//        fontWeight = FontWeight.Normal
//    ),
)

//TODO