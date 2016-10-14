package ninja.sakib.pultusorm.annotations;


/**
 * := Coded with love by Sakib Sami on 9/28/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

/**
 * Annotation to mark a field as primary key
 */

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class PrimaryKey()
