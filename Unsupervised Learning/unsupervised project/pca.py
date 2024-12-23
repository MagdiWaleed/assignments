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
        get_eigen = get_Eigens()
        eigen_values,eigen_vectors = get_eigen.eig(matrix)
        return eigen_values,eigen_vectors


    def fit(self,image):
        normalized_img = self.normalization(image)
                            
        covariance_matrix = self.covariance(normalized_img)
        # print("covariance matrix: ",covariance_matrix)
        eigen_values,eigen_vectors = self.calc_eign(covariance_matrix) 
        # print("eigen_values: ",eigen_values)
        eigen_vectors =np.array( [ [value/np.linalg.norm(eigen_vector) for value in eigen_vector] for eigen_vector in eigen_vectors])

        indecis = np.argsort(eigen_values)[::-1]
        
        eigen_vectors = eigen_vectors[indecis]
        self.eigen_values = eigen_values[indecis]

        self.components= eigen_vectors[:self.n_components]

    def transform(self,image):
        temp = deepcopy(image)
        temp = temp - self.mean
        new_image = np.dot(temp,self.components.T)
        return np.array(new_image)

    def reverse(self,image):
        result =np.dot(image,self.components)

        return result+self.mean

class get_Eigens():
    def __init__(self):
        pass
    def calc_determinant(self,matrix,depth=0):
        if matrix.shape ==(2,2):
            return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0]
        else:# if the shape is (3,3) or higher
            result=0
            for i in range(len(matrix)):
                helper = np.delete(matrix,i,axis=1)
                helper = np.delete(helper,0,axis=0)
                result+= (-1)**i * matrix[0][i]* self.calc_determinant(helper,depth+1)
            return result
        
    def calc_eigenvalue(self,matrix):
        # # y = symbols('y')
        # # idintity_matrix = np.zeros(matrix.shape);np.fill_diagonal(idintity_matrix,1)
        # # result =  matrix- y*idintity_matrix
        # # determinant = self.calc_determinant(result)
        # # equation = Eq(determinant,0)
        
        # return solve(equation,y)
        poly = np.poly(matrix)
        eigenvalues = np.roots(poly)
        return eigenvalues
    
    def calc_eigenvector(self,matrix, eigenvalues):
        eigenvectors = []#note the matrix must equalt to 8, 5, 4 and 3
        idintity_matrix = np.zeros(matrix.shape);np.fill_diagonal(idintity_matrix,1)

        for eigenvalue in eigenvalues:
            _, _, vh = np.linalg.svd(matrix - eigenvalue*idintity_matrix)
            eigenvector = vh[-1]  
            eigenvector = eigenvector / np.linalg.norm(eigenvector)  # Normalize the eigenvector
        
            if eigenvector[0] < 0:
                eigenvector = -eigenvector
            eigenvectors.append(eigenvector)

        
        return eigenvectors
    def main(self,matrix):
        # print(result)
        eigenvalues = self.calc_eigenvalue(matrix)
        eigenvalues = np.real(eigenvalues)
        eigenvectors =self.calc_eigenvector(matrix,eigenvalues)
        return np.array(eigenvalues),np.array(eigenvectors)
    @staticmethod
    def eig(matrix):
        get_eigen = get_Eigens()
        eigen_values,eigen_vectors = get_eigen.main(matrix)
        return eigen_values,eigen_vectors
