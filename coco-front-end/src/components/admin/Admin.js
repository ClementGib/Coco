import React from "react";
import SwaggerUI from "swagger-ui-react"
import "swagger-ui-react/swagger-ui.css"

function Admin() {
  return (
    <div className="App">
      <SwaggerUI url="http://127.0.0.1:8080/coco/openapi" />
    </div>
  );
}

export default Admin;