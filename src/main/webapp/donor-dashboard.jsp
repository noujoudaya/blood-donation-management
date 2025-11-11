<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Donor Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-danger px-4">
    <span class="navbar-brand mb-0 h1">Donor Dashboard</span>
</nav>

<div class="container mt-4">

    <div class="card shadow-sm mb-4">
        <div class="card-body">
            <h4>Your Profile</h4>
            <p>Blood Type: <strong>${bloodType}</strong></p>
            <p>Next Appointment: <strong>${nextAppointment}</strong></p>
        </div>
    </div>

    <div class="card shadow-sm">
        <div class="card-body">
            <h4>Your Donation History</h4>
            <p>Total Donations: <strong>${donationCount}</strong></p>
        </div>
    </div>

</div>

</body>
</html>
