# MPCameraApp

its a camera application that can be used to take pictures, upload them on cloud so that the images can be backup easily on cloud
the application have 4 major veiw
1. camera view
2. gallery veiw
3. list of images on cloud
4. list view details

# Camera features 

1. user can zoom
2. user can turn the flash on and off
3. user can flip the camera 

# Gallery features

1. user can upload the image on cloud
2. user can crop the image
3. user can delete the image
4. user can see all the clicked images 

# Technical Details

1. i am using CameraX Api under the hood for camera 
2. i am using firebase storage for saving the images on cloud 
3. i am using firestore to save the download url of the images for the list views
4. i am using MVVM Architecture 
5. i am using KODEIN dependency injection framework
6. i am using Kotlin coroutines to get rid of the async code
7. i am using navigation architecture components for navigation in between the fragments
8. i am using safeargs for passing the arguments in between the fragements
9. i am using Picasso for loading the images into the imageviews
