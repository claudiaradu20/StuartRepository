#Bug report




#  Bug Id:Id123
#  Environment: Sandbox
#  Severity: Critical
#  Description:
#    When calling the endpoint GET /jobs/{jobId} with the jobId of a job with status 'searching', we get null for status.
#    Expected: "status": "searching"
#    Found: "status": null

#  Data used to reproduce defect: jobId = 100262660
#  Response body with error:
#      "id": 100262660,
#      "created_at": "2022-04-24T15:34:07.000+02:00",
#      "status": null,
#      "package_type": null,
#      "transport_type": "truck"