package com.kirei.quizzes

data class Quiz (
    val id: Int,
    val text : String,
    val answers: List<String>,
    var isCurrent: Boolean = false
)

fun getListQuiz(): MutableList<Quiz> {
    return mutableListOf(
        Quiz(
            id = 0,
            text = "What is the last movie of Avengers?",
            answers = listOf("All of these", "Avengers the last", "Endgame", "Infinity War")
        ),
        Quiz(
            id = 1,
            text = "Who is the first Avengers?",
            answers = listOf("IronMan", "Thor", "Bucky", "Steve Rogers")
        ),
        Quiz(
            id = 2,
            text = "Who killed thanos? ",
            answers = listOf("The Infinity Stones", "IronMan", "God", "Thor")
        ),
        Quiz(
            id = 3,
            text = "What is Loki's last name?",
            answers = listOf("LauffeySon", "OdinSon", "Mahmudin", "Mukidi")
        ),
        Quiz(
            id = 4,
            text = "Who own the Time Stone?",
            answers = listOf(
                "Stephen Strange",
                "Doctor Strange",
                "Dormamu",
                "Ancient One"
            )
        ),
        Quiz(
            id = 5,
            text = "Who is Wanda's Husband?",
            answers = listOf("Bucky", "Vision", "Jarvis", "RDJ")
        ),
        Quiz(
            id = 6,
            text = "Where did Wanda live?",
            answers = listOf(
                "WestCoast",
                "WestView",
                "Western",
                "A house"
            )
        ),
        Quiz(
            id = 7,
            text = "Who is Loki's female variant?",
            answers = listOf("Lucy", "Sylvie", "Synthia", "Vivie")
        ),
        Quiz(
            id = 8,
            text = "How did Loki died?",
            answers = listOf("Because of Hulk", "Killed by Thanos", "Turn to a frog", "Stuck in the tva")
        ),
        Quiz(
            id = 9,
            text = "What is Steve Rogers doing right now?",
            answers = listOf("Hangin out with Bucky", "Dancin with Peggy", "I don't know", "Mutating to a new variant cause he is selfish")
        )
    )
}