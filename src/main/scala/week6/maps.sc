val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")

capitalOfCountry("US")


//capitalOfCountry("France") raise exception
capitalOfCountry get "France"
capitalOfCountry get "US"

//groupBy and orderBy like methods
val fruit = List("apple", "pear", "orange", "pineapple")
fruit sortWith (_.length < _.length)
fruit.sorted
fruit groupBy (_.head)



