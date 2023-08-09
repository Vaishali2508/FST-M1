import pandas as pd

dataframe=pd.read_excel("details.xlsx", sheet_name="Sheet1")
print(dataframe.shape)
print(dataframe["Email"])
dataframe=dataframe.sort_values(['FirstName'], ascending=[True])
print(dataframe["FirstName"].searchsorted)
