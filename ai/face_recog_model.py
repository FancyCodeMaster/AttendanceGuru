import pickle

filename = 'face_recog_model.sav'

model = pickle.load(open(filename, 'rb'))
