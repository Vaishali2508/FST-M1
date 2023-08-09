fruits_dict = {
    "apple" :"100" ,
    "banana":"50",
    "mango" :"100"
}
check=input("Enter Fruits")
if(check in fruits_dict) :
    print("Fruit is available")
else:
    print("Fruit is not available")