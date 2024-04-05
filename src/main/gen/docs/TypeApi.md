# TypeApi

All URIs are relative to *http://localhost:8080/EntJavaTeamProject_war/services*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllTypes**](TypeApi.md#getAllTypes) | **GET** /types | Returns a list of types |
| [**getTypeById**](TypeApi.md#getTypeById) | **GET** /types/{typeId} | Find type  by ID |


<a name="getAllTypes"></a>
# **getAllTypes**
> Map&lt;String, Integer&gt; getAllTypes()

Returns a list of types

Returns list of types

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TypeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/EntJavaTeamProject_war/services");

    TypeApi apiInstance = new TypeApi(defaultClient);
    try {
      Map<String, Integer> result = apiInstance.getAllTypes();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TypeApi#getAllTypes");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**Map&lt;String, Integer&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |

<a name="getTypeById"></a>
# **getTypeById**
> Type getTypeById(typeId)

Find type  by ID

find a type by the type id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.TypeApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/EntJavaTeamProject_war/services");

    TypeApi apiInstance = new TypeApi(defaultClient);
    Long typeId = 56L; // Long | ID of type that needs to be fetched
    try {
      Type result = apiInstance.getTypeById(typeId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling TypeApi#getTypeById");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **typeId** | **Long**| ID of type that needs to be fetched | |

### Return type

[**Type**](Type.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **400** | Invalid ID supplied |  -  |
| **404** | Region not found |  -  |

