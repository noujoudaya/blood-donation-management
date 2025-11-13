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
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Appointment - MediTrust Bootstrap Template</title>
    <meta name="description" content="">
    <meta name="keywords" content="">

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com" rel="preconnect">
    <link href="https://fonts.gstatic.com" rel="preconnect" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&family=Lato:ital,wght@0,100;0,300;0,400;0,700;0,900;1,100;1,300;1,400;1,700;1,900&family=Raleway:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/vendor/aos/aos.css" rel="stylesheet">
    <link href="assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
    <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
    <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">

    <!-- Main CSS File -->
    <link href="assets/css/main.css" rel="stylesheet">
    <!-- Custom CSS File -->
    <link href="assets/css/custom.css" rel="stylesheet">


</head>

<body class="appointment-page">



<main class="main">


    <!-- Appointmnet Section -->
    <section id="appointmnet" class="appointmnet section" >

        <div class="container" data-aos="fade-up" data-aos-delay="100">

            <div class="row gy-4">


                <div class="col-lg-6">
                    <div class="appointment-info">
                        <h3>Rejoignez le réseau MedConnect</h3>
                        <p class="mb-4">
                            Créez votre compte MedConnect pour accéder à une plateforme sécurisée reliant donneurs de sang, hôpitaux et patients. Ensemble, sauvons des vies — un don à la fois.
                        </p>

                        <div class="info-items">
                            <div class="info-item d-flex align-items-center mb-3" data-aos="fade-up" data-aos-delay="200">
                                <div class="icon-wrapper me-3">
                                    <i class="bi bi-droplet-half text-danger"></i>
                                </div>
                                <div>
                                    <h5>Pour les donneurs</h5>
                                    <p class="mb-0">Trouvez des demandes de don à proximité et suivez votre historique de dons.</p>
                                </div>
                            </div>

                            <div class="info-item d-flex align-items-center mb-3" data-aos="fade-up" data-aos-delay="250">
                                <div class="icon-wrapper me-3">
                                    <i class="bi bi-hospital text-primary"></i>
                                </div>
                                <div>
                                    <h5>Pour les hôpitaux</h5>
                                    <p class="mb-0">Gérez facilement les demandes de sang et connectez-vous avec des donneurs enregistrés.</p>
                                </div>
                            </div>

                            <div class="info-item d-flex align-items-center mb-3" data-aos="fade-up" data-aos-delay="300">
                                <div class="icon-wrapper me-3">
                                    <i class="bi bi-people text-success"></i>
                                </div>
                                <div>
                                    <h5>Pour les patients</h5>
                                    <p class="mb-0">Contactez rapidement en cas d’urgence pour obtenir de l’aide.</p>
                                </div>
                            </div>
                        </div>
<%--
                        <div class="emergency-contact mt-4" data-aos="fade-up" data-aos-delay="350">
                            <div class="emergency-card p-3">
                                <h6 class="mb-2"><i class="bi bi-telephone-fill me-2"></i>Need Urgent Help?</h6>
                                <p class="mb-0">Contact your nearest blood center through MedConnect support.</p>
                            </div>
                        </div>--%>
                    </div>
                </div>


                <!-- Register Form -->
                <div class="col-lg-6">
                    <div class="appointment-form-wrapper" data-aos="fade-up" data-aos-delay="200">
                        <form action="register" method="post">
                        <div class="row gy-3">
                                <!-- Name -->
                                <div class="col-md-6">
                                    <input type="text" name="prenom" class="form-control" placeholder="Prénom"
                                           required>
                                </div>
                                <div class="col-md-6">
                                    <input type="text" name="nom" class="form-control" placeholder="Nom" required>
                                </div>

                                <!-- Email & Phone -->
                                <div class="col-md-6">
                                    <input type="email" name="email" class="form-control" placeholder="Adresse e-mail"
                                           required>
                                </div>
                                <div class="col-md-6">
                                    <input type="tel" name="telephone" class="form-control" placeholder="Numéro de téléphone"
                                           required>
                                </div>

                                <!-- Password -->
                                <div class="col-md-6">
                                    <input type="password" name="motDePasse" class="form-control" placeholder="Mot de passe"
                                           required>
                                </div>
                                <div class="col-md-6">
                                    <input type="password" name="confirmPassword" class="form-control"
                                           placeholder="Confirmer le mot de passe" required>
                                </div>

                                <div class="col-md-6">
                                    <select name="role" class="form-select" required>
                                        <option value="">S'inscrire en tant que</option>
                                        <option value="donneur">Donneur</option>
                                        <option value="hopital">Hôpital / Patient</option>
                                        <option value="admin">Administrateur</option>
                                    </select>

                                </div>

                                <!-- Submission -->
                                <div class="col-12">
                                    <button type="submit" class="btn btn-appointment w-100">
                                        <i class="bi bi-person-plus me-2"></i>S'inscrire
                                    </button>
                                </div>
                                <div class="col-12 text-center mt-3">
                                    <p>Already have an account? <a href="login.jsp">Se connecter</a></p>
                                </div>


                            </div>
                        </form>
                    </div>
                </div>

                <!-- End Register Form -->

            </div>

        </div>

    </section><!-- /Appointmnet Section -->

</main>



<!-- Scroll Top -->
<a href="#" id="scroll-top" class="scroll-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

<!-- Preloader -->
<div id="preloader"></div>

<!-- Vendor JS Files -->
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>
<script src="assets/vendor/aos/aos.js"></script>
<script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
<script src="assets/vendor/imagesloaded/imagesloaded.pkgd.min.js"></script>
<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>

<!-- Main JS File -->
<script src="assets/js/main.js"></script>

</body>

</html>









