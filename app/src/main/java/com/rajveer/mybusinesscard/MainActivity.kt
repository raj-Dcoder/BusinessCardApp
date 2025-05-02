package com.rajveer.mybusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rajveer.mybusinesscard.ui.theme.MyBusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyBusinessCardTheme {
                BusinessCard()
            }
        }
    }
}

@Composable
fun BusinessCard(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .background(Color(0xFFE0F7FA)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        // logo, name title section
        Column(
            modifier = Modifier
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            val image = painterResource(R.drawable.profile)
            Image(
                painter = image,
                contentDescription = null
            )
            Spacer(Modifier.height(8.dp))
            Text(
                stringResource(R.string.user_name),
                textAlign = TextAlign.Center,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(8.dp))
            Text(
                stringResource(R.string.position_title),
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Normal
            )
        }
        // contacts section
        Column(
            modifier = Modifier.padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            ContactInfo(
                icon = Icons.Filled.Phone,
                contactData = stringResource(R.string.mobile_no)
            )
            ContactInfo(
                icon = Icons.Filled.Email,
                contactData = stringResource(R.string.email_id)
            )
            ContactInfo(
                icon = Icons.Filled.Home,
                contactData = stringResource(R.string.home_town)
            )
        }
    }
}

@Composable
fun ContactInfo(
    icon: ImageVector,
    contactData: String
){
    Row(
        modifier = Modifier
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        Text(
            text = contactData,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MyBusinessCardTheme {
        BusinessCard()
    }
}