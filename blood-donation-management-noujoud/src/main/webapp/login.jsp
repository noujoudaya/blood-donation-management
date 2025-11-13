<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String successMsg = (String) session.getAttribute("successMsg");
    String errorMsg = (String) session.getAttribute("errorMsg");

    if (successMsg != null) {
%>
<div class="alert alert-success"><%= successMsg %></div>
<%
        session.removeAttribute("successMsg");
    }

    if (errorMsg != null) {
%>
<div class="alert alert-danger"><%= errorMsg %></div>
<%
        session.removeAttribute("errorMsg");
    }
%>

<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Connexion - MedConnect</title>

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/css/main.css" rel="stylesheet">
    <link href="assets/css/custom.css" rel="stylesheet">
</head>

<body class="appointment-page">

<main class="main">
    <section id="login" class="appointmnet section">
        <div class="container" data-aos="fade-up" data-aos-delay="100">
            <div class="row gy-4">

                <div class="col-lg-6">
                    <div class="appointment-info">
                        <h3>Bienvenue sur MedConnect</h3>
                        <p class="mb-4">
                            Connectez-vous à votre compte pour gérer vos dons, vos demandes ou vos services hospitaliers.
                        </p>

                        <div class="info-items">
                            <div class="info-item d-flex align-items-center mb-3" data-aos="fade-up" data-aos-delay="200">
                                <div class="icon-wrapper me-3"><i class="bi bi-heart text-danger"></i></div>
                                <div>
                                    <h5>Donneurs</h5>
                                    <p class="mb-0">Accédez à vos dons et consultez les demandes autour de vous.</p>
                                </div>
                            </div>

                            <div class="info-item d-flex align-items-center mb-3" data-aos="fade-up" data-aos-delay="250">
                                <div class="icon-wrapper me-3"><i class="bi bi-hospital text-primary"></i></div>
                                <div>
                                    <h5>Hôpitaux</h5>
                                    <p class="mb-0">Gérez vos besoins en sang et trouvez des donneurs disponibles.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Login Form -->
                <div class="col-lg-6">
                    <div class="appointment-form-wrapper" data-aos="fade-up" data-aos-delay="200">
                        <form action="login" method="post">
                            <div class="row gy-3">

                                <div class="col-12">
                                    <input type="email" name="email" class="form-control" placeholder="Adresse e-mail" required>
                                </div>

                                <div class="col-12">
                                    <input type="password" name="password" class="form-control" placeholder="Mot de passe" required>
                                </div>

                                <div class="col-12">
                                    <button type="submit" class="btn btn-appointment w-100">
                                        <i class="bi bi-box-arrow-in-right me-2"></i>Se connecter
                                    </button>
                                </div>

                                <div class="col-12 text-center mt-3">
                                    <p>Pas encore de compte ? <a href="register.jsp">Créer un compte</a></p>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- End Login Form -->

            </div>
        </div>
    </section>
</main>

<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/main.js"></script>

</body>
</html>
