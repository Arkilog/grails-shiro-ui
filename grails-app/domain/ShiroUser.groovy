class ShiroUser {

    String firstName

    String lastName

    String username

    String passwordHash

	String email

	String additionalInfo

	Date dateCreated

	Date lastUpdated

    Boolean passwordChangeRequiredOnNextLogon = false

    static hasMany = [ roles: ShiroRole, permissions: String ]

    static constraints = {
        firstName(nullable: false, blank: false)
        lastName(nullable: false, blank: false)
        username(unique: true, nullable: false, blank: false, size: 5..20)
        email(unique: true, email: true)
        additionalInfo(nullable: true)
        passwordHash(nullable: false, maxSize: 64, bindable: false)
        passwordChangeRequiredOnNextLogon(nullable: true)
    }

    static mapping = {
		cache true
		cache roles: true
		cache permissions: true
	}

    @Override
	String toString(){
        username
    }

}
