import face_recog_model
import cv2
from PIL import Image
from numpy import asarray
from mtcnn.mtcnn import MTCNN

# extract a single face from a given photograph
# def extract_face(image):
# 	# load image from file
# 	# convert to RGB, if needed
# 	# image = image.convert('RGB')
# 	# convert to array
# 	pixels = asarray(image)
# 	# create the detector, using default weights
# 	detector = MTCNN()
# 	# detect faces in the image

# 	results = detector.detect_faces(pixels)
# 	# extract the bounding box from the first face
# 	x1, y1, width, height = results[0]['box']
# 	# bug fix
# 	x1, y1 = abs(x1), abs(y1)
# 	x2, y2 = x1 + width, y1 + height
# 	# extract the face
# 	face = pixels[y1:y2, x1:x2]
# 	# resize pixels to the model size
# 	image = Image.fromarray(face)
# 	return image


# Load the pre-trained face detection cascade
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')

# Initialize the video capture
video_capture = cv2.VideoCapture(0)

while True:
    # Read the frame from the video capture
    ret, frame = video_capture.read()

    # Convert the frame to grayscale for face detection
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    # Detect faces in the grayscale frame
    faces = face_cascade.detectMultiScale(gray, scaleFactor=1.1, minNeighbors=5, minSize=(30, 30))

    # Draw a rectangle around each detected face
    for (x, y, w, h) in faces:
        cv2.rectangle(frame, (x, y), (x+w, y+h), (0, 255, 0), 2)

    # Display the resulting frame
    cv2.imshow('Video', frame)

    # Break the loop if 'q' is pressed
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# Release the video capture and close the OpenCV windows
video_capture.release()
cv2.destroyAllWindows()


# function for face detection with mtcnn





# test model on a random example from the test dataset
# selection = choice([i for i in range(testX.shape[0])])
# selection = choice([6])
# print(testX.shape[0])
# random_face_pixels = testX_faces[selection]
# random_face_emb = testX[selection]
# random_face_class = testy[selection]
# random_face_name = out_encoder.inverse_transform([random_face_class])
# # prediction for the face
# samples = expand_dims(random_face_emb, axis=0)
# yhat_class = model.predict(samples)
# print(yhat_class)
# yhat_prob = model.predict_proba(samples)
# # get name
# class_index = yhat_class[0]
# class_probability = yhat_prob[0,class_index] * 100
# predict_names = out_encoder.inverse_transform(yhat_class)
# print('Predicted: %s (%.3f)' % (predict_names[0], class_probability))
# print('Expected: %s' % random_face_name[0])
# # plot for fun
# pyplot.imshow(random_face_pixels)
# title = '%s (%.3f)' % (predict_names[0], class_probability)
# pyplot.title(title)
# pyplot.show()
