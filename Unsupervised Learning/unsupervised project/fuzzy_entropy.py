import numpy as np

class FuzzyEntropy():
    def __init__(self):
        pass
    def calc_alpha(self,s,d_dash):
        # numerator, denominator = (12.43).as_integer_ratio()
        # (numerator,denominator)

        alpha = -(np.log(s))/d_dash
        return alpha
    def Ecledian_distance(self,samples):
        distances = []
        for i in samples:
            subdistance = []
            for j in samples:
                distance = np.sqrt(((i - j)**2).sum())
                subdistance.append(distance)
            distances.append(subdistance)
        return np.array(distances)
    
    def similarities(self,distances,alpha):
        similarities = np.exp(- distances* alpha)
        return np.array(similarities)
    
    def entropies(self,similarities):
        entropies = []
        for i in range(len(similarities)):
            i_entropy=0
            for j in range(len(similarities[i])):
                if i!=j:
                    i_entropy += (similarities[i][j]*np.log2(similarities[i][j]))+((1-similarities[i][j])*np.log2(1-similarities[i][j]))
            entropies.append(-i_entropy)
        return np.array(entropies)
    def get_next_entropy(self,sampels,entropies):
        sorted_indices = np.argsort(entropies)
        for i in range(len(sorted_indices)):
            if not sampels[sorted_indices[i]][1]:
                return sorted_indices[i]
            
    
    def fit(self,sampels,s=0.5):
        distance =self.Ecledian_distance(sampels)
        # print("distances: \n",distance)
        d_dash = distance.mean()
        # print("d_dash: ",d_dash)
        alpha = self.calc_alpha(s,d_dash)
        # print("alpha: ",alpha)
        similarities = self.similarities(distance,alpha)
        # print("similarities:\n",similarities)
        entropies = self.entropies(similarities)
        # print("entropies:\n",entropies)
        selected_entropy = np.argmin(entropies)
        # print("Minimum entropy index: ",selected_entropy," with: ",entropies[0])
        i= 0
        sampels=[[t, False] for t in sampels]
        dictainary= {}
        
        while True:
            class_name = "class "+str(i)

            i= i+1
            dictainary[class_name] ={
                "class_centroid": sampels[selected_entropy][0]
            }
            sampels[selected_entropy][1]= True
            data = []
            for similarity_i in range(len(similarities[selected_entropy])):
                similarity = similarities[selected_entropy][similarity_i]
                if similarity>= s and not sampels[similarity_i][1]:
                    data.append(sampels[similarity_i][0])
                    sampels[similarity_i][1]=True
            
            dictainary[class_name]["data"]= data
            selected_entropy = self.get_next_entropy(sampels,entropies)
            finished= True

            for t in sampels:
                if not t[1]:
                   finished= False
                   break

            if finished: 
                # print("im done")
                break
        return dictainary
            
