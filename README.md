Sumary
-------------

The Android app architecture guidelines recommend separating classes that have different responsibilities.
A UI controller is UI-based class like Activity or Fragment. UI controllers should only contain logic that handles UI and operating system interactions; they shouldn't contain data to be displayed in the UI. Put that data in a ViewModel.
The ViewModel class stores and manages UI-related data. The ViewModel class allows data to survive configuration changes such as screen rotations.
ViewModel is one of the recommended Android Architecture Components.
ViewModelProvider.Factory is an interface you can use to create a ViewModel object.

The table below compares UI controllers with the ViewModel instances that hold data for them:
-------------

|UI controller|ViewModel|
|---|---|
|An example of a UI controller is the ScoreFragment that you created in this codelab.|An example of a ViewModel is the ScoreViewModel that you created in this codelab.|
|Doesn't contain any data to be displayed in the UI.|Contains data that the UI controller displays in the UI.|
|Contains code for displaying data, and user-event code such as click listeners.|Contains code for data processing.|
|Destroyed and re-created during every configuration change.|Destroyed only when the associated UI controller goes away permanently—for an activity, when the activity finishes, or for a fragment, when the fragment is detached.|
|Contains views.|Should never contain references to activities, fragments, or views, because they don't survive configuration changes, but the ViewModel does.|
|Contains a reference to the associated ViewModel.|Doesn't contain any reference to the associated UI controller.|

LiveData
----------
LiveData is an observable data holder class that is lifecycle-aware, one of the Android Architecture Components.

You can use LiveData to enable your UI to update automatically when the data updates.

LiveData is observable, which means that an observer like an activity or an fragment can be notified when the data held by the LiveData object changes.

LiveData holds data; it is a wrapper that can be used with any data.

LiveData is lifecycle-aware, meaning that it only updates observers that are in an active lifecycle state such as STARTED or RESUMED.

To add LiveData
----------
Change the type of the data variables in ViewModel to LiveData or MutableLiveData.

MutableLiveData is a LiveData object whose value can be changed. MutableLiveData is a generic class, so you need to specify the type of data that it holds.

To change the value of the data held by the LiveData, use the setValue() method on the LiveData variable.

To encapsulate LiveData
----------

The LiveData inside the ViewModel should be editable. Outside the ViewModel, the LiveData should be readable. This can be implemented using a Kotlin backing property.

A Kotlin backing property allows you to return something from a getter other than the exact object.

To encapsulate the LiveData, use private MutableLiveData inside the ViewModel and return a LiveData backing property outside the ViewModel.

Observable LiveData
----------

LiveData follows an observer pattern. The "observable" is the LiveData object, and the observers are the methods in the UI controllers, like fragments. Whenever the data wrapped

inside LiveData changes, the observer methods in the UI controllers are notified.

To make the LiveData observable, attach an observer object to the LiveData reference in the observers (such as activities and fragments) using the observe() method.

This LiveData observer pattern can be used to communicate from the ViewModel to the UI controllers.
