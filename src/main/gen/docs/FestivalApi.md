# FestivalApi

All URIs are relative to *http://localhost:8080/EntJavaTeamProject_war/services*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addFestival**](FestivalApi.md#addFestival) | **POST** /festivals/{festivalName}/{regionId}/{typeId}/{startDate} | Add a new festival |
| [**findAllFestivals**](FestivalApi.md#findAllFestivals) | **GET** /festivals | Finds All Festivals |
| [**findFestivalsByType**](FestivalApi.md#findFestivalsByType) | **GET** /festivals/types/{typeId} | Finds Festivals by type |
| [**getById**](FestivalApi.md#getById) | **GET** /festivals/{festivalId} | Find festival by ID |
| [**getByRegion**](FestivalApi.md#getByRegion) | **GET** /festivals/regions/{regionId} | Find festival by region |


<a name="addFestival"></a>
# **addFestival**
> Festival addFestival(festivalName, regionId, typeId, startDate, festival)

Add a new festival

Add a new festival

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FestivalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/EntJavaTeamProject_war/services");

    FestivalApi apiInstance = new FestivalApi(defaultClient);
    String festivalName = "festivalName_example"; // String | name of festival to add
    Long regionId = 56L; // Long | ID of region of festival
    Long typeId = 56L; // Long | ID of type of festival
    String startDate = "startDate_example"; // String | start date of festival
    Festival festival = new Festival(); // Festival | Create a new festival
    try {
      Festival result = apiInstance.addFestival(festivalName, regionId, typeId, startDate, festival);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FestivalApi#addFestival");
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
| **festivalName** | **String**| name of festival to add | |
| **regionId** | **Long**| ID of region of festival | |
| **typeId** | **Long**| ID of type of festival | |
| **startDate** | **String**| start date of festival | |
| **festival** | [**Festival**](Festival.md)| Create a new festival | |

### Return type

[**Festival**](Festival.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml, application/x-www-form-urlencoded
 - **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Successful operation |  -  |
| **400** | Invalid input |  -  |
| **422** | Validation exception |  -  |

<a name="findAllFestivals"></a>
# **findAllFestivals**
> List&lt;Festival&gt; findAllFestivals()

Finds All Festivals

returns a list of all festivals

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FestivalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/EntJavaTeamProject_war/services");

    FestivalApi apiInstance = new FestivalApi(defaultClient);
    try {
      List<Festival> result = apiInstance.findAllFestivals();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FestivalApi#findAllFestivals");
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

[**List&lt;Festival&gt;**](Festival.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, application/xml

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | successful operation |  -  |
| **400** | Invalid value |  -  |

<a name="findFestivalsByType"></a>
# **findFestivalsByType**
> Festival findFestivalsByType(typeId)

Finds Festivals by type

Finds a list of festivals by type

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FestivalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/EntJavaTeamProject_war/services");

    FestivalApi apiInstance = new FestivalApi(defaultClient);
    Long typeId = 56L; // Long | ID of type to return
    try {
      Festival result = apiInstance.findFestivalsByType(typeId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FestivalApi#findFestivalsByType");
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
| **typeId** | **Long**| ID of type to return | |

### Return type

[**Festival**](Festival.md)

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
| **404** | No festivals found |  -  |

<a name="getById"></a>
# **getById**
> Festival getById(festivalId)

Find festival by ID

Returns a single festival

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FestivalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/EntJavaTeamProject_war/services");

    FestivalApi apiInstance = new FestivalApi(defaultClient);
    Long festivalId = 56L; // Long | ID of festival to return
    try {
      Festival result = apiInstance.getById(festivalId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FestivalApi#getById");
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
| **festivalId** | **Long**| ID of festival to return | |

### Return type

[**Festival**](Festival.md)

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
| **404** | Festival not found |  -  |

<a name="getByRegion"></a>
# **getByRegion**
> Festival getByRegion(regionId)

Find festival by region

Returns a lisf of festivals in the specified region

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.FestivalApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/EntJavaTeamProject_war/services");

    FestivalApi apiInstance = new FestivalApi(defaultClient);
    Long regionId = 56L; // Long | ID of region to return
    try {
      Festival result = apiInstance.getByRegion(regionId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling FestivalApi#getByRegion");
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
| **regionId** | **Long**| ID of region to return | |

### Return type

[**Festival**](Festival.md)

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
| **404** | No festivals found |  -  |

