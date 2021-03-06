import controllers.MembersController
import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MainApp : Application() {

    @Throws(Exception::class)
    override fun start(stage: Stage) {
        val loader = FXMLLoader(javaClass.getResource("members.fxml"))
        val root: Parent = loader.load()
        val scene = Scene(root)
        stage.minWidth = root.minWidth(-1.0)
        stage.minHeight = root.minHeight(-1.0)
        stage.title = "WebRTC Demo"
        stage.scene = scene
        stage.setOnHidden { (loader.getController() as? MembersController)?.close()  }
        stage.show()
    }

    companion object {
        @JvmStatic
        fun main(vararg args: String) {
            val logger: Logger = LoggerFactory.getLogger(MainApp::class.java)
            launch(MainApp::class.java, *args)
        }
    }
}