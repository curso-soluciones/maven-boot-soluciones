# maven-boot-soluciones
 1.  Debemos a gregar las siguientes dependencias
   
   compile 'org.springframework.android:spring-android-rest-template:2.0.0.M2'
    compile 'org.springframework.android:spring-android-core:1.0.1.RELEASE'
    compile 'com.fasterxml.jackson.core:jackson-databind:2.5.2'
    
  2.   Despues de buildTyps agregamos:
     packagingOptions {
        exclude 'META-INF/ASL2.0'
        exclude 'META-INF/LICENSE'
        exclude 'META-INF/license.txt'
        exclude 'META-INF/NOTICE'
        exclude 'META-INF/notice.txt'
    }
    lintOptions {
        //
        abortOnError false
    }:
    
    
    Hacemos una tarea asincornica dentro de nuestra main activity como clase interna:
        class TareaAsincronicaGetTodos extends AsyncTask<String, Integer, Integer>{

        @Override
        protected Integer doInBackground(String... strings) {
          //No se ejecuta en el thread principal

            return 0;
        }
        @Override
        public void onPostE
