# StoreManagementSystem

## Actiuni/Interogari
 - Print stock
 - Print product by code
 - Print tickets
 - Print ticket by id
 - Login
 - Print users
  - For all users: Print info
 - For cashiers only:
   - Fire cashier
 - For providers only:
   - Print orders
   - Print order by id
   - Print orders value
 - For customers only:
   - Change location
   - Change shipping info
   - Change credit card
   
## Tipuri de obiecte
 - Address
 - Card
 - PackageType
 - ProductCategory
 - Product
 - ProductEntry
 - Order
 - Ticket
 - User (si urmatoarele clase derivate din User)
   - Cashier
   - Provider
   - Customer
   
## Services
 - ShopService
 - UserService
 - CashierService
 - ProviderService
 - CustomerService
 
 ## Users
 - Cashier
   - **Username**: Cashier
   - **Password**: password
 - Provider
   - **Username**: Provider
   - **Password**: password
 - Customer
   - **Username**: Customer
   - **Password**: password
