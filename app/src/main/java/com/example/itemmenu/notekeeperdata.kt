package com.example.itemmenu

class Courseinfo (val courseId:String, val title:String) {
    override fun toString(): String {
       return title
    }
}

class NoteInfo(var course: String, var tittle: String, val text: String)
