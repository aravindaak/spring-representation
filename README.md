# Representation

## APIs
	List of APIs available to be used

### /api/v1/person/get (GET)
	* Find the list of people 
	
### /api/v1/location/find (POST)
	 * Finding possible locations of a person based on previous known locations, last known location and time elapsed
 ```
 	{
    	"personId":"60d07fa55f780517733b558c",
    	"lastKnownLocation":"Boulder, CO",
    	"timeElapsed": 1000
	}
 ```
	 * Finding possible locations (like previous), with number of nodes traversed to consider in input.
 ```
 	{
    	"personId":"60d07fa55f780517733b558c",
		"lastKnownLocation":"Boulder, CO",
    	"nodesToConsider": 2,
    	"timeElapsed": 2141
	}
 ```