## Introduction
This is an implementation of a RESTful web service that performs CRUD operations (Create, Read, Update, and Delete) for a Vehicle entity.
Vehicle


| API        | Description           |
| ------------- |:-------------:|
| **GET** vehicles/*{id}*     |  Returns a vehicle specified by its unique ID. |
| **GET** vehicles      | Returns all vehicles in the directory.      |
| **GET** vehicles?make={***make***}&model={***model***}&year={***year***}      | Returns vehicles in the directory filtered by their properties.      |
| **POST** vehicles     | Adds a vehicle to the directory |
| **PUT** vehicles     | Updates a vehicle to the directory.      |
| **DELETE** vehicles/*{id}*     | Deletes a vehicle specified by its unique ID from the directory. |

