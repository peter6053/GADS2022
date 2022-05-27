package com.example.itemmenu

class datamanager {
    val corses = hashMapOf<String, Courseinfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializecourses()
        initializenotes()
    }

    fun initializecourses() {
        var course = Courseinfo("android_intents", "Android progrsming with intents")
        corses.set(course.courseId, course)

        course = Courseinfo(courseId = "Android async", "Andrid asyn programing and services")
        corses.set(course.title, course)


        course = Courseinfo(title = "Java funndamental the java language", courseId = "java_lang")
        corses.set(course.courseId, course)

        course = Courseinfo(courseId = "Java_core", title = "java fundamental the core platform")
        corses.set(course.courseId, course)
    }
    fun initializenotes() {
        var note = NoteInfo("android intents","andro=id intents","andrid intents")
        notes.add(note)

        note = NoteInfo("android intents","andro=id intents","andrid intents")
        notes.add(note)

        note = NoteInfo("android intents","andro=id intents","andrid intents")
        notes.add(note)

        note = NoteInfo("android intents","andro=id intents","andrid intents")
        notes.add(note)
    }

}