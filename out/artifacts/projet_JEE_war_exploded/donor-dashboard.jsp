<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <title>MedConnect - Espace Donneur</title>

    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: #f8f9fc;
        }

        /* Sidebar navy + texte blanc */
        .sidebar {
            width: 230px;
            height: 100vh;
            background-color: white;   /* Navy Blue */
            color: red;
            position: fixed;
            box-shadow: 2px 0 8px rgba(0,0,0,0.15);
        }

        .sidebar h4 {
            color: red; /* Titre sidebar en rouge */
            font-weight: 700;
        }

        .sidebar a {
            color:#0a1a2f ;
            padding: 12px 20px;
            display: block;
            text-decoration: none;
            font-weight: 500;
            border-radius: 8px;
        }

        .sidebar a:hover {
            background-color: #0a1a2f;
            color: white;
        }

        /* Header */
        .topbar {
            margin-left: 230px;
            padding: 15px 20px;
            background: white;
            border-bottom: 1px solid #ddd;
        }

        .topbar h4 {
            color: red; /* titre header en rouge */
            font-weight: 700;
        }

        .btn-danger {
            background-color: #d62828;
            border-color: #d62828;
        }

        .btn-danger:hover {
            background-color: #b71d1d;
        }

        /* Cards */
        .card-header-soft {
            background: #f4f4f4;         /* gris très clair */
            color: #0a1a2f;              /* titre des cartes en rouge */
            font-weight: 700;
            padding: 10px 20px;
            border-left: 4px solid #0a1a2f; /* accent navy */
        }

        .small-note {
            font-size: 0.85rem;
            color: gray;
        }

        .highlight {
            color: #d62828;
            font-weight: 700;
        }
    </style>

</head>

<body>

<!-- Sidebar -->
<div class="sidebar">
    <h4 class="text-center py-4">MedConnect</h4>

    <a href="#">Tableau de bord</a>
    <a href="#">Mes dons</a>
    <a href="#">Campagnes</a>
    <a href="#">Profil</a>
    <a href="#">Déconnexion</a>
</div>

<!-- Topbar -->
<div class="topbar d-flex justify-content-between align-items-center">
    <h4>Bienvenue, ${donor.name}</h4>
    <button class="btn btn-danger">Programmer un Don</button>
</div>

<!-- Content -->
<div class="container-fluid" style="margin-left:230px; margin-top:20px;">

    <div class="row g-3">

        <!-- Card 1 -->
        <div class="col-md-3">
            <div class="card shadow-sm">
                <div class="card-header-soft">Total des Dons</div>
                <div class="card-body">
                    <h3 class="highlight">${donor.totalDonations}</h3>
                    <span class="small-note">Depuis votre inscription</span>
                </div>
            </div>
        </div>

        <!-- Card 2 -->
        <div class="col-md-3">
            <div class="card shadow-sm">
                <div class="card-header-soft">Dernier Don</div>
                <div class="card-body">
                    <h4>${donor.lastDonation}</h4>
                    <span class="small-note">Merci pour votre générosité</span>
                </div>
            </div>
        </div>

        <!-- Card 3 -->
        <div class="col-md-3">
            <div class="card shadow-sm">
                <div class="card-header-soft">Prochain Don Possible</div>
                <div class="card-body">
                    <h4>${donor.nextEligibleDate}</h4>
                    <span class="small-note">Repos nécessaire entre les dons</span>
                </div>
            </div>
        </div>

        <!-- Card 4 -->
        <div class="col-md-3">
            <div class="card shadow-sm">
                <div class="card-header-soft">Groupe Sanguin</div>
                <div class="card-body">
                    <h3 class="highlight">${donor.bloodGroup}</h3>
                </div>
            </div>
        </div>
    </div>

    <!-- GRAPHIQUES -->
    <div class="row mt-3">
        <div class="col-md-8">
            <div class="card shadow-sm">
                <div class="card-header-soft">Historique de vos dons</div>
                <div class="card-body">
                    <canvas id="donChart"></canvas>
                </div>
            </div>
        </div>

        <div class="col-md-4">
            <div class="card shadow-sm">
                <div class="card-header-soft">Campagnes soutenues</div>
                <div class="card-body">
                    <canvas id="pieChart"></canvas>
                </div>
            </div>
        </div>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>
    new Chart(document.getElementById("donChart"), {
        type: "line",
        data: {
            labels: ["2021", "2022", "2023", "2024"],
            datasets: [{
                label: "Dons effectués",
                data: [1, 2, 3, 5],
                borderColor: "#0d47a1",
                backgroundColor: "rgba(13, 71, 161, 0.2)",
                tension: 0.4
            }]
        }
    });

    new Chart(document.getElementById("pieChart"), {
        type: "doughnut",
        data: {
            labels: ["Locales", "Nationales", "Urgences"],
            datasets: [{
                data: [60, 25, 15],
                backgroundColor: [
                    "#1e3a8a",  /* Bleu foncé */
                    "#3b82f6",  /* Bleu moyen */
                    "#93c5fd"   /* Bleu clair */
                ]
            }]
        }
    });
</script>

</body>

</html>
