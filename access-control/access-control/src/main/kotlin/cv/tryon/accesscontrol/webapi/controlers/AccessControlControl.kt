package cv.tryon.accesscontrol.webapi.controlers

import cv.tryon.accesscontrol.data.reposotories.DeviceRepository
import cv.tryon.accesscontrol.webapi.controlers.abstract.AccessControlAbstrat
import cv.tryon.accesscontrol.webapi.model.inputs.DeviceInputModel
import cv.tryon.accesscontrol.webapi.model.output.DeviceOutputModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController

@RequestMapping("access")
class AccessControlControl(
        repository: DeviceRepository
) : AccessControlAbstrat(repository) {

    @PostMapping("create")
    override fun create(@RequestBody inputModel: DeviceInputModel): DeviceOutputModel {
        return super.create(inputModel)
    }

    @GetMapping("{id}")
    override fun find(@PathVariable id: String): DeviceOutputModel {
        return super.find(id)
    }
}
