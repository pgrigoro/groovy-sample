package dynamicCodeInTemplate

/*
Create Dynamic Methods ...

In Groovy we can write classes and write an implementation for methods we don't even know exist.
We must implement the method methodMissing() which is invoked when other methods cannot be found.
Because methodMissing() is invoked each time another method cannot be found, it can be expensive,
but we can use the metaClass property to cache the new method. Next time the cached version is used.
 */

class LanguagesList {
    def list = ['Java', 'Groovy', 'Scala']

    // Set metaClass property to ExpandoMetaClass instance, so we
    // can add dynamic methods.
    LanguagesList() {
        def mc = new ExpandoMetaClass(LanguagesList, false, true)
        mc.initialize()
        this.metaClass = mc
    }

    def methodMissing(String name, args) {
        // Intercept method that starts with find.
        if (name.startsWith("find")) {
            def result = list.find { it == name[4..-1] }
            // Add new method to class with metaClass.
            this.metaClass."$name" = {-> result + "[cache]" }
            result
        } else {
            throw new MissingMethodException(name, this.class, args)
        }
    }
}

def languages = new LanguagesList()
assert 'Groovy' == languages.findGroovy()
assert 'Scala' == languages.findScala()
assert 'Java' == languages.findJava()
assert !languages.findRuby()

assert 'Groovy[cache]' == languages.findGroovy()
assert 'Scala[cache]' == languages.findScala()
assert 'Java[cache]' == languages.findJava()
