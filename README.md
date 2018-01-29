1) Network call has been establish, but it uses android async task, due to which business logic won't be able to leverage JUnit for testing, Its needs to change to be independent of Android classes.<br>

2) MVP has been tried to as architecture for separation of concern. This is done to increase test coverage with junit. However a lot of dependency on android elements it would need to require instrument test (androidTest)<br>
  
3) Dagger is used for dependency injects <br>

4) following libraries are used <br>
        GSON - well json parsing with reflection <br>
        OKHttp - for Network calls <br>
        Picasso - used to load images to from URL</br>
        
5) Faced issues with segregation while implementing code, In given condition business logic should have build first independent
of android elements to check sorting and network calls, after this MVP architecture should be followed and then the essentials of UI element with Material design. 