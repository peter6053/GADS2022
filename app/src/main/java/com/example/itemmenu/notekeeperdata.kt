package com.example.itemmenu

data class Courseinfo (val courseId:String, val title:String) {
    override fun toString(): String {
       return title
    }
}

 data class NoteInfo(var course: String, var tittle: String, val text: String)
