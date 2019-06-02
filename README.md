# StoreManagementSystem

## Actiuni/Interogari
 - Print stock
 - Print product by code
 - Add product
 - Remove product
 - Print tickets
 - Print ticket by id
 - Login  
 - Register
   - Can choose what ype of account to create: Cashier, Customer or Provider
 - Print users
  - For all users: Print info
 - For cashiers only:
   - Fire cashier
 - For providers only:
   - Print orders
   - Print order by id
   - Change registration Id
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
 - AuditService
 - DbService
 - FileService
 
 ## Users (work only if database is available)
 - Cashier
   - **Username**: cashier1
   - **Password**: password
 - Provider
   - **Username**: provider1
   - **Password**: password
 - Customer
   - **Username**: customer1
   - **Password**: password
