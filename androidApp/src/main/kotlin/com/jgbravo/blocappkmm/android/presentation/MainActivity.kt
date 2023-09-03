package com.jgbravo.blocappkmm.android.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jgbravo.blocappkmm.android.navigation.Router
import com.jgbravo.blocappkmm.android.presentation.note_details.NoteDetailsScreen
import com.jgbravo.blocappkmm.android.presentation.note_details.NoteDetailsViewModel
import com.jgbravo.blocappkmm.android.presentation.note_list.NoteListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Router.NoteList.SCREEN) {
                composable(route = Router.NoteList.SCREEN) {
                    NoteListScreen(navController = navController)
                }
                composable(
                    route = "${Router.NoteDetails.SCREEN}/{${Router.NoteDetails.Args.NOTE_ID}}",
                    arguments = listOf(
                        navArgument(name = NoteDetailsViewModel.KEY_NOTE_ID) {
                            type = NavType.StringType
                            defaultValue = ""
                        }
                    )
                ) { backStackEntry ->
                    val noteId = backStackEntry.arguments?.getString(NoteDetailsViewModel.KEY_NOTE_ID) ?: ""
                    NoteDetailsScreen(noteId = noteId, navController = navController)
                }
            }
        }
    }
}