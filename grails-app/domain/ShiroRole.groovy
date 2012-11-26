class ShiroRole {
    String name
    String description
    Date dateCreated
    Date lastUpdated

    static hasMany = [ users: ShiroUser, permissions: String ]

    static belongsTo = ShiroUser

    static constraints = {
        name(blank: false, unique: true)
        description(nullable: true)
    }

    static mapping = {
        cache true
        users cache: true
        permissions cache: true
    }

    @Override
    String toString() {
        name
    }
}
