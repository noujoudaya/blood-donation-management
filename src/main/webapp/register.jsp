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
                        <h3>Join the MedConnect Network</h3>
                        <p class="mb-4">
                            Create your MedConnect account to access a secure platform connecting blood donors, hospitals, and patients.
                            Together, we save lives — one donation at a time.
                        </p>

                        <div class="info-items">
                            <div class="info-item d-flex align-items-center mb-3" data-aos="fade-up" data-aos-delay="200">
                                <div class="icon-wrapper me-3">
                                    <i class="bi bi-droplet-half text-danger"></i>
                                </div>
                                <div>
                                    <h5>For Donors</h5>
                                    <p class="mb-0">Find nearby donation requests and track your contribution history.</p>
                                </div>
                            </div>

                            <div class="info-item d-flex align-items-center mb-3" data-aos="fade-up" data-aos-delay="250">
                                <div class="icon-wrapper me-3">
                                    <i class="bi bi-hospital text-primary"></i>
                                </div>
                                <div>
                                    <h5>For Hospitals</h5>
                                    <p class="mb-0">Easily manage blood requests and connect with registered donors.</p>
                                </div>
                            </div>

                            <div class="info-item d-flex align-items-center mb-3" data-aos="fade-up" data-aos-delay="300">
                                <div class="icon-wrapper me-3">
                                    <i class="bi bi-people text-success"></i>
                                </div>
                                <div>
                                    <h5>For Patients</h5>
                                    <p class="mb-0">Reach out quickly when urgent help is needed.</p>
                                </div>
                            </div>
                        </div>

                        <div class="emergency-contact mt-4" data-aos="fade-up" data-aos-delay="350">
                            <div class="emergency-card p-3">
                                <h6 class="mb-2"><i class="bi bi-telephone-fill me-2"></i>Need Urgent Help?</h6>
                                <p class="mb-0">Contact your nearest blood center through MedConnect support.</p>
                            </div>
                        </div>
                    </div>
                </div>


                <!-- Register Form -->
                <div class="col-lg-6">
                    <div class="appointment-form-wrapper" data-aos="fade-up" data-aos-delay="200">
                        <form action="forms/appointment.php" method="post" class="appointment-form php-email-form">
                            <div class="row gy-3">
                                <!-- Name -->
                                <div class="col-md-6">
                                    <input type="text" name="prenom" class="form-control" placeholder="First Name"
                                           required>
                                </div>
                                <div class="col-md-6">
                                    <input type="text" name="nom" class="form-control" placeholder="Last Name" required>
                                </div>

                                <!-- Email & Phone -->
                                <div class="col-md-6">
                                    <input type="email" name="email" class="form-control" placeholder="Email Address"
                                           required>
                                </div>
                                <div class="col-md-6">
                                    <input type="tel" name="telephone" class="form-control" placeholder="Phone Number"
                                           required>
                                </div>

                                <!-- Password -->
                                <div class="col-md-6">
                                    <input type="password" name="motDePasse" class="form-control" placeholder="Password"
                                           required>
                                </div>
                                <div class="col-md-6">
                                    <input type="password" name="confirmPassword" class="form-control"
                                           placeholder="Confirm Password" required>
                                </div>

                                <div class="col-md-6">
                                    <select name="role" class="form-select" required>
                                        <option value="">Register As</option>
                                        <option value="donneur">Donneur</option>
                                        <option value="hopital">Hôpital / Patient</option>
                                        <option value="admin">Administrateur</option>
                                    </select>

                                </div>

                                <!-- Submission -->
                                <div class="col-12">
                                    <div class="loading">Loading</div>
                                    <div class="error-message"></div>
                                    <div class="sent-message">Your account has been created successfully!</div>

                                    <button type="submit" class="btn btn-appointment w-100">
                                        <i class="bi bi-person-plus me-2"></i>Register
                                    </button>
                                </div>
                                <div class="col-12 text-center mt-3">
                                    <p>Already have an account? <a href="login.jsp">Sign In</a></p>
                                </div>


<%--                                <div class="col-12">
                                    <div class="loading">Loading</div>
                                    <div class="error-message"></div>
                                    <div class="sent-message">Your appointment request has been sent successfully. We will contact you shortly!</div>

                                    <button type="submit" class="btn btn-appointment w-100">
                                        <i class="bi bi-calendar-plus me-2"></i>Book Appointment
                                    </button>
                                </div>--%>

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









