class ShiroRole {
    String name
	String description
	Date dateCreated
	Date lastUpdated

    static hasMany = [ users: ShiroUser, permissions: String ]

    static belongsTo = ShiroUser

    static constraints = {
        name(nullable: false, blank: false, unique: true)
        description(nullable: true)
    }

    static mapping = {
		cache true
		cache users : true
		cache permissions : true
	}

    @Override
	String toString(){
        name
    }
}
