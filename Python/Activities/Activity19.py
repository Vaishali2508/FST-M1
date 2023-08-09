import pandas as pd
from pandas import ExcelFile
from pandas import ExcelWriter
data = {
    "FirstName":["Satvik", "Avinash", "Lahri"],
    "LastName":["Shah", "Kati", "Rath"],
    "Email":["satshah@example.com","avinash@example.com", "lahri.rath@example.com"],
    "PhoneNumber":["456782356","5896767532","4543222787"]
}
dataframe = pd.DataFrame(data)
writer=ExcelWriter("details.xlsx")

dataframe.to_excel(writer,"Sheet1",index=False)

writer.close()