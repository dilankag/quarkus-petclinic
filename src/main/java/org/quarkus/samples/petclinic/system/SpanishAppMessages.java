package org.quarkus.samples.petclinic.system;

import io.quarkus.qute.i18n.Localized;
import io.quarkus.qute.i18n.Message;

@Localized("es")
public interface SpanishAppMessages extends AppMessages {

    @Override
    @Message("Quarkus Pet Clinic")
    String product_title();

    @Override
    @Message("Buscar Propietario")
    String find_owner();

    @Override
    @Message("Editar Propietario")
    String edit_owner();

    @Override
    @Message("Apellido")
    String last_name();

    @Override
    @Message("Añadir Propietario")
    String add_owner();

    @Override
    @Message("Buscar Propietarios")
    String find_owners();

    @Override
    @Message("Nombre")
    String name();

    @Override
    @Message("Nombre de pila")
    String first_name();

    @Override
    @Message("Ops")
    String error();

    @Override
    @Message("Usuario no encontrado!")
    String error_user_not_found();

    @Override
    @Message("Credenciales de usuario no coincidentes!")
    String error_user_credentials_not_matched();

    @Override
    @Message("Credenciales de usuario no proporcionadas!")
    String error_user_credentials_not_supplied();

    @Override
    @Message("La autenticación del usuario ha fallado!")
    String error_user_authentication_has_failed();

    @Override
    @Message("OTP no coincidente!")
    String error_otp_not_matched();

    @Override
    @Message("La usuario ya existe!")
    String error_user_already_exist();

    @Override
    @Message("Veterinarios")
    String veterinarians();

    @Override
    @Message("ninguna")
    String none();

    @Override
    @Message("Inicio")
    String home();

    @Override
    @Message("Dirección")
    String address();

    @Override
    @Message("Teléfono")
    String telephone();

    @Override
    @Message("Correo electrónico")
    String email();

    @Override
    @Message("Contraseña")
    String password();

    @Override
    @Message("Mascotas")
    String pets();

    @Override
    @Message("Especialidades")
    String specialties();

    @Override
    @Message("Bienvenido a")
    String welcome_to();

    @Override
    @Message("Registrarse en")
    String sign_in_to();

    @Override
    @Message("Nuevo en")
    String new_to();

    @Override
    @Message("De regreso")
    String back_to();

    @Override
    @Message("Registrarse")
    String sign_in();

    @Override
    @Message("Inscribirse")
    String sign_up();

    @Override
    @Message("Desconectar")
    String sign_out();

    @Override
    @Message("¿Has olvidado tu contraseña?")
    String forgot_password();

    @Override
    @Message("Crea una cuenta")
    String create_an_account();

    @Override
    @Message("Ciudad")
    String city();

    @Message("Fecha Nacimiento")
    String birthdate();

    @Override
    @Message("Mascotas y Visitas")
    String pets_and_visits();

    @Override
    @Message("Tipo")
    String type();

    @Override
    @Message("Añadir Visita")
    String add_visit();

    @Override
    @Message("Añadir Mascota")
    String add_pet();

    @Override
    @Message("Editar Mascota")
    String edit_pet();

    @Override
    @Message("Fecha Visita")
    String visit_date();

    @Override
    @Message("Mascota")
    String pet();

    @Override
    @Message("Descripción")
    String description();

    @Override
    @Message("Algo salió mal!!!")
    String something_went_wrong();

    @Override
    @Message("Propietario")
    String owner();

    @Override
    @Message("Usuaria")
    String user();

    @Override
    @Message("Fecha")
    String date();

    @Override
    @Message("Visitas Anteriores")
    String previous_visits();

    @Override
    @Message("información")
    String information();

    @Override
    @Message("OTP")
    String OTP();

    @Override
    @Message("Verificar")
    String verify();

    @Override
    @Message("Alerta")
    String alert();

}
