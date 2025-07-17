
# 🧪 Postman Collections – Day 20 (Task & Customer APIs)

This folder contains four Postman collections used to test the RESTful endpoints of the **Day 20 Spring Boot project**, which includes:

- ✅ Task Tracker System
- ✅ Bank Management System

---

## 🚀 How to Use

### 1. **Open Postman**  
Download Postman from: https://www.postman.com/downloads/

### 2. **Import Collections**

Click `Import` → drag & drop any `.postman_collection.json` file, or import manually.

### 3. **Set Environment Variable**

Set a `base_url` variable in a Postman environment:

base\_url = [http://localhost:8080/api/v1](http://localhost:8080/api/v1)

Then use the collections as-is without needing to edit each request.

### **Alternatively, you can access my [Postman workspace](https://test66-1743.postman.co/workspace/Day-20~1f8e157b-0bfc-4022-9a53-f60156236e7f/collection/36845546-70699781-7246-4a12-82e0-ad5b17b25d2f?action=share&creator=36845546), but it might be down when you see this!**

---

## 📂 Collection Overview

| Collection Name                       | Description                                                                  |
|--------------------------------------|------------------------------------------------------------------------------|
| 🟦 **Tasks Endpoints**               | One request per task endpoint: CRUD, SEARCH                                  |
| 🟪 **Tasks Test Flow**               | Full task API testing flow including: valid add/update/delete, and 404 paths |
| 🟧 **Customers Endpoints**           | One request per customer endpoint: CRUD, deposit, withdrawal                 |
| 🟩 **Customers Test Flow**           | Full customer API testing flow including: validations, balance rules, 404s   |

---

## 📎 Tips

- Run the **Test Flow** collections to hit all logic branches (success/fail/edge cases).
- Use **Endpoints** collections for quick checks or isolated testing.

---
