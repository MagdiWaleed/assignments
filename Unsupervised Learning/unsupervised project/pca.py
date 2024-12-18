import numpy as np
from copy import deepcopy
class PCA:
    def __init__(self, n_components=2):
        self.n_components = n_components
        self.components = None
        self.mean = None
        

    def normalization(self,image):
        temp = deepcopy(image)
        mean = temp.mean(axis=0)
        temp = temp - mean
        self.mean= mean
        return temp
    

    def covariance(self,data):
        return np.dot(data.T,data)/len(data)

    def calc_eign(self,matrix):
        eigen_values,eigen_vectors = np.linalg.eig(matrix)
        return eigen_values,eigen_vectors


    def fit(self,image):
        normalized_img = self.normalization(image)
                            
        covariance_matrix = self.covariance(normalized_img)

        eigen_values,eigen_vectors = self.calc_eign(covariance_matrix) 

        eigen_vectors = eigen_vectors.T   


        indecis = np.argsort(eigen_values)[::-1]
        
        eigen_vectors = eigen_vectors[indecis]

        self.components= eigen_vectors[:self.n_components]
    def transform(self,image):
        temp = deepcopy(image)
        temp = temp - self.mean
        new_image = np.dot(temp,self.components.T)
        return np.array(new_image)

    def reverse(self,image):
        result =np.dot(image,self.components)

        return result+self.mean