from tqdm import trange
import numpy as np
from sklearn.model_selection import train_test_split
import random


class LinearRegression:
    X_train, y_train, X_val, y_val = None, None, None, None
    weight = None
    batch_size = None
    iteration = None
    cost_hist = None
    learning_rate = None


    def __init__(self):
        pass
    
    # method to start the training process
    def fit(self, X_train, y_train, val_split = None, epoch = 1, optimizer = None, learning_rate = 0.001, batch_size = 1, metrics = {}, quiet = True):
        # model initialization
        self.learning_rate = learning_rate
        self.batch_size = batch_size
        self.iteration = int(np.ceil((X_train.shape[0] % self.batch_size)/X_train.shape[0]) +(X_train.shape[0]-(X_train.shape[0] % self.batch_size) )/ self.batch_size) 
        self.cost_hist = []

        if val_split is not None:
            self.X_train, self.X_val, self.y_train, self.y_val = train_test_split(X_train,y_train,train_size=val_split)
            self.X_val = np.array(np.c_[self.X_val,np.ones(self.X_val.shape[0])]) # pad column of 1 at the left
            self.y_val = np.array(self.y_val)
        else:
            self.X_train, self.y_train = X_train, y_train

        self.X_train = np.array(np.c_[self.X_train,np.ones(self.X_train.shape[0])]) # pad column of 1 at the left
        self.y_train = np.array(self.y_train)
        
        # random initialization of weight parameters
        self.weight = np.random.rand(self.X_train.shape[1])*5
        
        if quiet:
            for i in range(epoch):
                if optimizer == "SGD":
                    self._SGD()
                else:
                    self._BGD()
                self.evaluate(i,metrics=metrics) if val_split is not None else None
        else:
            with trange(epoch, unit="Epoch") as pbar:
                for i in pbar:
                    pbar.set_description(f"Epoch #{i+1}: ")
                    if optimizer == "SGD":
                        # print(f"{i+1}/{epoch}")
                        self._SGD()
                    else:
                        # print(f"{i+1}/{epoch}")
                        self._BGD()
                    self.evaluate(i,metrics=metrics) if val_split is not None else None

        
    # private method to calculate cost
    def _BGDcost(self):
        # hypothesis
        h = self.X_train.dot(self.weight)
        # cost
        j = h - self.y_train
        # save a record
        self.cost_hist.append(j)
        
        return j
    
    # private method to calculate cost
    def _SGDcost(self,i):
        # hypothesis
        h = np.array(self.X_train[i]).dot(self.weight)
        # cost
        j = h - self.y_train[i]
        # save a record
        self.cost_hist.append(j)
        
        return j

    # private method to calculate cost
    def _MiniBatchcost(self,start,end):
        # hypothesis
        h = np.array(self.X_train[start:end]).dot(self.weight)
        # cost
        j = h - self.y_train[start:end]
        # save a record
        self.cost_hist.append(j)
    
        return j

    # private method for Batch Gradient Descent    
    def _BGD(self):
        j = self._BGDcost()
        self.weight = self.weight - self.learning_rate * (1/self.X_train.shape[0])*(self.X_train.T.dot(j))
    
    # private method for Stochastic Gradient Descent and Mini-Batch Gradien Descent
    def _SGD(self):
        if self.batch_size == 1:
            random.seed(42)
            shuffle = random.sample(range(self.X_train.shape[0]),self.X_train.shape[0])
            for elem in shuffle:
                j = self._SGDcost(elem)
                self.weight = self.weight - self.learning_rate *(self.X_train[elem].T.dot(j))
        else:
            current = 0
            for i in range(self.iteration):
                if i == self.iteration-1:
                    j = self._MiniBatchcost(current,self.X_train.shape[0]+1)
                    self.weight = self.weight - self.learning_rate * (1/(self.X_train.shape[0]-current)) * (self.X_train[current:].T.dot(j))
                else:
                    j = self._MiniBatchcost(current, current+self.batch_size)
                    self.weight = self.weight - self.learning_rate * (1/self.batch_size) * (self.X_train[current:current+self.batch_size].T.dot(j))
                current += self.batch_size

    def evaluate(self,epoch,metrics = {}):
        print(f"Validation for Epoch#{epoch}")
        y_pred = self.X_val.dot(self.weight)
        for methodName, method in metrics.items():
            print(f"{methodName} = {method(self.y_val,y_pred)}")

    # method to evaluate the trained model
    def predict(self, X_test):
        return np.array(np.c_[X_test,np.ones(X_test.shape[0])]).dot(self.weight)

    # method to get training history
    def getTrainingHistory(self):
        return self.cost_hist
         