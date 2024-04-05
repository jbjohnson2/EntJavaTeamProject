# RegionApi

All URIs are relative to *http://localhost:8080/EntJavaTeamProject_war/services*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getAllRegions**](RegionApi.md#getAllRegions) | **GET** /regions | Returns a list of regions |
| [**getRegionById**](RegionApi.md#getRegionById) | **GET** /regions/{regionId} | Find region  by ID |


<a name="getAllRegions"></a>
# **getAllRegions**
> Map&lt;String, Integer&gt; getAllRegions()

Returns a list of regions

Returns list of regions

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.RegionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/EntJavaTeamProject_war/services");

    RegionApi apiInstance = new RegionApi(defaultClient);
    try {
      Map<String, Integer> result = apiInstance.getAllRegions();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RegionApi#getAllRegions");
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

<a name="getRegionById"></a>
# **getRegionById**
> Region getRegionById(regionId)

Find region  by ID

find a region by the region id

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.RegionApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:8080/EntJavaTeamProject_war/services");

    RegionApi apiInstance = new RegionApi(defaultClient);
    Long regionId = 56L; // Long | ID of region that needs to be fetched
    try {
      Region result = apiInstance.getRegionById(regionId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling RegionApi#getRegionById");
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
| **regionId** | **Long**| ID of region that needs to be fetched | |

### Return type

[**Region**](Region.md)

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

