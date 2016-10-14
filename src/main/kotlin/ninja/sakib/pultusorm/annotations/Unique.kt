package ninja.sakib.pultusorm.annotations

/**
 * := Coded with love by Sakib Sami on 10/4/16.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */

/**
 * Annotation to mark a field as unique
 */

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class Unique()
