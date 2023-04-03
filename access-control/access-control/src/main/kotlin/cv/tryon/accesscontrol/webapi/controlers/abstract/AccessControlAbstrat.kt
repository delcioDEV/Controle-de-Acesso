package cv.tryon.accesscontrol.webapi.controlers.abstract

import cv.tryon.accesscontrol.data.model.Device
import cv.tryon.accesscontrol.data.reposotories.DeviceRepository
import cv.tryon.accesscontrol.webapi.model.inputs.DeviceInputModel
import cv.tryon.accesscontrol.webapi.model.output.DeviceOutputModel

abstract class AccessControlAbstrat(
        private val repository: DeviceRepository
) : AccessControlServices<DeviceInputModel, DeviceOutputModel> {

    override fun create(inputModel: DeviceInputModel): DeviceOutputModel {
        val device = Device(
                macAddress = inputModel.macAddress,
                name = inputModel.name,
                model = inputModel.model,
        )
        val save = repository.save(device)

        println("______________________________________")
        println("Deivice Id: ${save.id}")
        println("______________________________________")

        return DeviceOutputModel(
                macAddress = save.macAddress,
                name = save.name,
                model = save.model
        )
    }

    override fun find(id: String): DeviceOutputModel {
        val findById = repository.findById(id).orElseThrow()

        return DeviceOutputModel(
                macAddress = findById.macAddress,
                name = findById.name,
                model = findById.model
        )
    }
}

/*
data class Input(
        val id : String
)
data class Output(
        val id : String
)*/
