class ShiroUser {

    String firstName
    String lastName
    String username
    String passwordHash
    String email
    Date dateCreated
    Date lastUpdated

    Boolean passwordChangeRequiredOnNextLogon = false

    static hasMany = [ roles: ShiroRole, permissions: String ]

    static constraints = {
        firstName(blank: false)
        lastName(blank: false)
        username(unique: true, blank: false, size: 5..20)
        email(unique: true, email: true)
        passwordHash(display:false)
        passwordChangeRequiredOnNextLogon(nullable: true)
    }

    static mapping = {
        cache true
        roles cache: true
        permissions cache: true
    }

    @Override
    String toString() {
        username
    }
}
